SET mypath=%~dp0
cd %mypath%
SET driverpath=%~d0
%driverpath%
SET mynewpath=%cd%

SET configFilepath=%mynewpath%\executionConfig.csv
echo suitefile=%configFilepath%
For /F "tokens=1,2 delims=," %%i in (%configFilepath%) do call :execute %%i %%j

:execute
	Set "execute=%~1"
	Set "suitefile=%~2"	 
	IF "%execute%"=="" GOTO :EOF
	if %execute% == yes (
		if %suitefile% NEQ suitefile (
		echo suitefile=%suitefile%
		mvn clean install test -Dsuitename=%suitefile%
		
		)
		timeout 5
	 
	)
	
	
:end


goto :eof