@echo off

cd /d "E:\Software Testing Course\swaglabs-automation"

echo =====================================
echo Running TestNG Suite...
echo =====================================

call mvn test -DsuiteXmlFile=testng.xml

IF ERRORLEVEL 1 (
    echo.
    echo Tests Failed - Allure will not open.
    pause
    exit /b
)

echo.
echo =====================================
echo Opening Allure Report...
echo =====================================

call allure serve allure-results

pause