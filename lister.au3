
while True
	$clientList = ProcessList("game.dll")
	Sleep(200)
	ConsoleWrite("client trovati: " & $clientList[0][0] &  @CRLF)
	If $clientList[0][0] > 0 Then
		For $i = 1 To $clientList[0][0]
			ConsoleWrite("---> client " & $i & " PID: " & $clientList[$i][1]&  @CRLF)
		Next
	EndIf
WEnd
