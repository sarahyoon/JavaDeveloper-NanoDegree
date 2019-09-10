package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String msg){

            onlineSessions.forEach((username, session)-> {
                try{
                    onlineSessions.get(username).getBasicRemote().sendText(msg);
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            });
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) {

        Message message = new Message();
        message.setName(session.getPathParameters().get("username"));
        onlineSessions.put(message.getName(), session);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        jsonObject.put("type", Message.Type.SPEAK);
        jsonObject.put("onlineCount", onlineSessions.size());
        jsonStr = jsonObject.toJSONString();

        sendMessageToAll(jsonStr);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws Exception {

        onlineSessions.remove(session.getPathParameters().get("username"));

    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
