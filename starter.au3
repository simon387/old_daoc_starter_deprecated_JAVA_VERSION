#NoTrayIcon
;mutexKiller()
;While ProcessExists("login.dll") <> 0
;	ProcessClose("login.dll")
;WEnd
;While ProcessExists("camelot.bin") <> 0
;	ProcessClose("camelot.bin")
;WEnd
$clientListPrima = ProcessList("game.dll")

If $CmdLine[0] <> 5 Then
	MsgBox(0, 0, "errore interno JAVA vs AUTOIT")
	Exit
EndIf

Local $wdir = $CmdLine[1] ; working dir del login.dll
Local $path = $CmdLine[2] ; path completo inclusivo di nome del login.dll
Local $acco = $CmdLine[3] ; nome account
Local $pass = $CmdLine[4] ; pass account
Local $mode = $CmdLine[5] ; 0 senza toon 1 con toon

Local $pid = Run($path, $wdir)
;If GUICtrlRead($Combo_account) == "No account selected" Then
;	ControlSend("Dark Age of Camelot", "", "[CLASS:Button; INSTANCE:1]", "{enter}")
;	GUICtrlSetData($Label_, "Done")
;Else
If $pid == 0 Then
	Consolewrite("Error on starting camelot.exe" & @CRLF)
Else
	Local $win_handle = 0
	While $win_handle == 0
		Local $list = WinList("Dark Age of Camelot")
		If IsArray($list) == 1 Then
			For $i = 1 To $list[0][0]
				Local $size = WinGetClientSize($list[$i][1])
				If IsArray($size) == 1 Then
					If $size[0] == 413 And $size[1] == 258 Then $win_handle = $list[$i][1]
					If $size[0] == 550 And $size[1] == 318 Then $win_handle = $list[$i][1]
				EndIf
			Next
		EndIf
	WEnd
	If ControlSetText($win_handle, "", "[CLASS:Edit; INSTANCE:2]", $acco) == 1 Then
		Consolewrite("Account setted" & @CRLF)
		If ControlSetText($win_handle, "", "[CLASS:Edit; INSTANCE:1]", $pass) Then
			Consolewrite("Password setted" & @CRLF)
			ControlSend($win_handle, "", "[CLASS:Button; INSTANCE:1]", "{enter}")
		Else
			Consolewrite("Error on setting password" & @CRLF)
		EndIf
	Else
		Consolewrite("Error on setting account ID" & @CRLF)
	EndIf
EndIf


; e li stampi tutti i PID e fai decidere al java


if $CmdLine[5] == 1 Then
	While True
		$clientListDopo = ProcessList("game.dll")
		If $clientListPrima[0][0] == ($clientListDopo[0][0] - 1) Then
			For $i = 1 To $clientListDopo[0][0]
				If esiste($clientListDopo[$i][1]) == False Then
					ConsoleWrite ($clientListDopo[$i][1] & @CRLF)
				EndIf
			Next
			ExitLoop
		EndIf
	WEnd
EndIf

Func esiste($elemento)
	For $i = 1 To $clientListPrima[0][0]
		If $elemento == $clientListPrima[$i][1] Then Return True
	Next
	Return False
EndFunc

Consolewrite("fine elaborazione" & @CRLF)

;EndIf