/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


	var wsocket;
	var serviceLocation = "ws://0.0.0.0:8080/hascode/chat/";
	var $pseudo;
	var $message;
	var $chatWindow;
	var $room = 0;
        
    $(document).ready(function() {
                $pseudo=$('#pseudonyme').val();
                $room=0;
		$("#salle").hide();
		$('#entrer').click(function(evt) {
			evt.preventDefault();
                        $pseudo = $('#pseudonyme').val();
                        $room = $('#room').val();
                        if ($pseudo!=="" && $room!==null){
                            connectToChatserver();
                            $('.infoRoomUser').text('Chat : '+$pseudo + "@" + $room);
                            $("#home").slideUp("slow");
                            $("#salle").slideDown("slow");
                            $message.focus();
                        }
		});
		$('#do-chat').submit(function(evt) {
			evt.preventDefault();
			sendMessage();
		});
 
		$('#sortir').click(function(){
			quitterSalle();
		});
    });
 
    //
    function onMessageReceived(evt) {
		//var msg = eval('(' + evt.data + ')');
	var msg = JSON.parse(evt.data); // native API
	var $messageLine = $('<tr><td class="received">' + msg.recu
				+ '</td><td class="user label label-info">' + msg.emetteur
				+ '</td><td class="message badge">' + msg.message
				+ '</td></tr>');
	$chatWindow.append($messageLine);
    }
        
         // connection
    function connectToChatserver() {
		room = $('#Salle option:selected').val();
		wsocket = new WebSocket(serviceLocation + room);
		wsocket.onmessage = onMessageReceived;
    }
        
    function sendMessage() {
	var msg = '{"message":"' + $message.val() + '", "sender":"'
			+ $pseudo.val() + '", "received":""}';
	wsocket.send(msg);
	$message.val('').focus();
    }
        
    function quitterSalle() {
	wsocket.close();
	$chatWindow.empty();
	$('#salle').hide();
	$('#home').show();
	$pseudo.focus();
    }