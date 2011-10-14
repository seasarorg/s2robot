@echo off

setlocal
%~d0
cd %~p0
call _project.bat

rem /nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
rem Specify the file path to be used as build-properties.
rem nnnnnnnnnn/
set MY_PROPERTIES_PATH=build.properties

rem /nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
rem Execute {JDBC and Document}.
rem nnnnnnnnnn/
call %DBFLUTE_HOME%\etc\cmd\_df-jdbc.cmd %MY_PROPERTIES_PATH%

if "%pause_at_end%"=="y" (
  pause
)

