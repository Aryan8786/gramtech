@echo off
setlocal enabledelayedexpansion
title RuralRise / GramTech — Java Web Application Server

echo ===============================================================
echo   RuralRise / GramTech Web Application (Java Edition)
echo   Topic: Technology Support for Rural Startups
echo   College CEP Project
echo ===============================================================
echo.

:: Detect Java JDK
set "JAVAC_EXE=javac"
set "JAVA_EXE=java"

if exist "C:\Users\DELL\.jdks\jbr-21.0.11\bin\javac.exe" (
    set "JAVAC_EXE=C:\Users\DELL\.jdks\jbr-21.0.11\bin\javac.exe"
    set "JAVA_EXE=C:\Users\DELL\.jdks\jbr-21.0.11\bin\java.exe"
    goto :JAVA_FOUND
)

if defined JAVA_HOME (
    if exist "%JAVA_HOME%\bin\javac.exe" (
        set "JAVAC_EXE=%JAVA_HOME%\bin\javac.exe"
        set "JAVA_EXE=%JAVA_HOME%\bin\java.exe"
        goto :JAVA_FOUND
    )
)

:JAVA_FOUND
echo [*] Using Java Compiler: "%JAVAC_EXE%"
echo [*] Using Java Runtime : "%JAVA_EXE%"
echo.

:: Create bin directory if not exists
if not exist "bin" mkdir "bin"

echo [*] Compiling Java Web Server and Data Repository...
"%JAVAC_EXE%" -encoding UTF-8 -d bin logic\GramTechData.java GramTechServer.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Compilation failed with error code %ERRORLEVEL%.
    pause
    exit /b %ERRORLEVEL%
)

echo [OK] Compilation successful!
echo.
echo [*] Launching GramTechServer on http://localhost:8080 ...
echo [*] Opening web browser...
start http://localhost:8080

echo.
echo ===============================================================
echo  Server is now running! Press Ctrl+C in this window to stop.
echo ===============================================================
echo.

"%JAVA_EXE%" -cp bin GramTechServer 8080

pause
