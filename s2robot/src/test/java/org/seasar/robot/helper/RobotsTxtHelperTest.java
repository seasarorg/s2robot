/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.robot.helper;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.seasar.extension.unit.S2TestCase;
import org.seasar.robot.entity.RobotsTxt;

public class RobotsTxtHelperTest extends S2TestCase {
    public RobotsTxtHelper robotsTxtHelper;

    @Override
    protected String getRootDicon() throws Throwable {
        return "app.dicon";
    }

    public void testParse() {
        RobotsTxt robotsTxt;
        final InputStream in =
            RobotsTxtHelperTest.class.getResourceAsStream("robots.txt");
        try {
            robotsTxt = robotsTxtHelper.parse(in);
        } finally {
            IOUtils.closeQuietly(in);
        }

        for (String userAgent : new String[] { "S2Robot", "S2Robot/1.0",
            "Mozilla S2Robot" }) {
            assertTrue(robotsTxt.allows("/aaa", userAgent));
            assertTrue(robotsTxt.allows("/private/", userAgent));
            assertTrue(robotsTxt.allows("/private/index.html", userAgent));
            assertTrue(robotsTxt.allows("/help/", userAgent));
            assertTrue(robotsTxt.allows("/help.html", userAgent));
            assertTrue(robotsTxt.allows("/help/faq.html", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/index.html", userAgent));
            assertEquals(0, robotsTxt.getCrawlDelay(userAgent));
        }

        for (String userAgent : new String[] { "BruteBot", "FOO BruteBot/1.0" }) {
            assertFalse(robotsTxt.allows("/aaa", userAgent));
            assertFalse(robotsTxt.allows("/private/", userAgent));
            assertFalse(robotsTxt.allows("/private/index.html", userAgent));
            assertFalse(robotsTxt.allows("/help/", userAgent));
            assertFalse(robotsTxt.allows("/help.html", userAgent));
            assertFalse(robotsTxt.allows("/help/faq.html", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/index.html", userAgent));
            assertEquals(1314000, robotsTxt.getCrawlDelay(userAgent));
        }

        for (String userAgent : new String[] { "GOOGLEBOT", "GoogleBot",
            "googlebot" }) {
            assertTrue(robotsTxt.allows("/aaa", userAgent));
            assertTrue(robotsTxt.allows("/private/", userAgent));
            assertTrue(robotsTxt.allows("/private/index.html", userAgent));
            assertTrue(robotsTxt.allows("/help/", userAgent));
            assertTrue(robotsTxt.allows("/help.html", userAgent));
            assertTrue(robotsTxt.allows("/help/faq.html", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/index.html", userAgent));
            assertEquals(1, robotsTxt.getCrawlDelay(userAgent));
        }

        for (String userAgent : new String[] { "UnknownBot", "", " ", null }) {
            assertTrue(robotsTxt.allows("/aaa", userAgent));
            assertFalse(robotsTxt.allows("/private/", userAgent));
            assertFalse(robotsTxt.allows("/private/index.html", userAgent));
            assertFalse(robotsTxt.allows("/help/", userAgent));
            assertFalse(robotsTxt.allows("/help.html", userAgent));
            assertTrue(robotsTxt.allows("/help/faq.html", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/", userAgent));
            assertTrue(robotsTxt.allows("/foo/bar/index.html", userAgent));
            assertEquals(3, robotsTxt.getCrawlDelay(userAgent));
        }

        assertFalse(robotsTxt.allows("/aaa", "Crawler"));
        assertTrue(robotsTxt.allows("/bbb", "Crawler"));
        assertTrue(robotsTxt.allows("/ccc", "Crawler"));
        assertTrue(robotsTxt.allows("/ddd", "Crawler"));
        assertTrue(robotsTxt.allows("/aaa", "Crawler/1.0"));
        assertFalse(robotsTxt.allows("/bbb", "Crawler/1.0"));
        assertTrue(robotsTxt.allows("/ccc", "Crawler/1.0"));
        assertTrue(robotsTxt.allows("/ddd", "Crawler/1.0"));
        assertTrue(robotsTxt.allows("/aaa", "Crawler/2.0"));
        assertTrue(robotsTxt.allows("/bbb", "Crawler/2.0"));
        assertFalse(robotsTxt.allows("/ccc", "Crawler/2.0"));
        assertTrue(robotsTxt.allows("/ddd", "Crawler/2.0"));
        assertTrue(robotsTxt.allows("/aaa", "Hoge Crawler"));
        assertTrue(robotsTxt.allows("/bbb", "Hoge Crawler"));
        assertTrue(robotsTxt.allows("/ccc", "Hoge Crawler"));
        assertFalse(robotsTxt.allows("/ddd", "Hoge Crawler"));

        String[] sitemaps = robotsTxt.getSitemaps();
        assertEquals(2, sitemaps.length);
        assertEquals("http://www.example.com/sitmap.xml", sitemaps[0]);
        assertEquals("http://www.example.net/sitmap.xml", sitemaps[1]);

    }

    public void testParse_disable() {
        final InputStream in =
            RobotsTxtHelperTest.class.getResourceAsStream("robots.txt");
        robotsTxtHelper.setEnabled(false);
        try {
            assertNull(robotsTxtHelper.parse(in));
        } finally {
            robotsTxtHelper.setEnabled(true);
            IOUtils.closeQuietly(in);
        }
    }
}
