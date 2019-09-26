set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -classpath "%ProjectPath%bin;%ProjectPath%lib\*" org.testng.TestNG "%ProjectPath%bin\runBankGuruTestcases.xml"
pause 