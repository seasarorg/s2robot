/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
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
package org.seasar.robot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.seasar.robot.RobotCrawlAccessException;
import org.seasar.robot.entity.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shinsuke
 *
 */
public final class ResponseDataUtil {
    private static final Logger logger = LoggerFactory
        .getLogger(ResponseDataUtil.class);

    private ResponseDataUtil() {
    }

    public static File createResponseBodyFile(final ResponseData responseData) {
        File tempFile = null;
        final InputStream is = responseData.getResponseBody();
        FileOutputStream fos = null;
        try {
            tempFile = File.createTempFile("s2robot-", ".tmp");
            fos = new FileOutputStream(tempFile);
            StreamUtil.drain(is, fos);
        } catch (final Exception e) {
            IOUtils.closeQuietly(fos); // for deleting file
            // clean up
            if (tempFile != null && !tempFile.delete()) {
                logger.warn("Could not delete a temp file: " + tempFile);
            }
            throw new RobotCrawlAccessException(
                "Could not read a response body: " + responseData.getUrl(),
                e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(fos);
        }
        return tempFile;
    }
}
