@echo off
setlocal enabledelayedexpansion
title Push RuralRise / GramTech to GitHub

set "GIT_EXE=%~dp0.tools\git\cmd\git.exe"

if not exist "!GIT_EXE!" (
    where git >nul 2>&1
    if !ERRORLEVEL! EQU 0 (
        set "GIT_EXE=git"
    ) else (
        echo [ERROR] Git was not found!
        pause
        exit /b 1
    )
)

echo ===============================================================
echo   Push RuralRise / GramTech to GitHub
echo ===============================================================
echo.

set "REPO_URL=%~1"
if "%REPO_URL%"=="" (
    set /p "REPO_URL=Enter your GitHub Repository URL (e.g., https://github.com/username/repo.git): "
)

if "%REPO_URL%"=="" (
    echo [ERROR] No repository URL provided.
    pause
    exit /b 1
)

echo.
echo [*] Adding all changes...
"!GIT_EXE!" add .

echo [*] Committing changes...
"!GIT_EXE!" commit -m "Deploy RuralRise / GramTech web application" >nul 2>&1

echo [*] Configuring remote origin: %REPO_URL%
"!GIT_EXE!" remote remove origin >nul 2>&1
"!GIT_EXE!" remote add origin %REPO_URL%

echo [*] Pushing branch main to GitHub...
"!GIT_EXE!" branch -M main
"!GIT_EXE!" push -u origin main

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ===============================================================
    echo [SUCCESS] Code successfully pushed to GitHub!
    echo.
    echo  To view your live site on GitHub Pages:
    echo  1. Go to your GitHub repo Settings -> Pages
    echo  2. Under 'Branch', select 'main' and '/ (root)' or '/docs'
    echo  3. Click 'Save'
    echo ===============================================================
) else (
    echo.
    echo [NOTICE] If authentication failed, please log in to GitHub when prompted
    echo or ensure you have push permissions to this repository.
)

pause
