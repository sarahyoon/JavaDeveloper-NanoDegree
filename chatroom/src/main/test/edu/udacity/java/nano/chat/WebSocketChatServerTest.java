package edu.udacity.java.nano.chat;

        import org.junit.jupiter.api.Test;
        import org.junit.runner.RunWith;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebSocketChatServerTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebSocketChatServerTest{
    @Autowired
    private WebSocketChatServer webSocketChatServer;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriver webDriver2;

    private String test_url = "http://localhost:8080";

    @Test
    public void loginAndJoinTest()
    {
        webDriver = new HtmlUnitDriver();
        webDriver.get(test_url);

        WebElement username = webDriver.findElement(By.name("username"));
        username.sendKeys("aaa");

        WebElement login = webDriver.findElement(By.className("submit"));
        login.click();

        webDriver2 = new HtmlUnitDriver();
        String current_url = test_url + "/index?username="+username;
        webDriver2.get(current_url);
        assertThat(webDriver2.findElement(By.id("username")).getText()).isEqualTo(username);

    }

    @Test
    public void chatAndLeave()
    {
        webDriver = new HtmlUnitDriver();
        webDriver2 = new HtmlUnitDriver();

        String username="aaa";
        webDriver.get(test_url+"/index?username="+username);

        String username2="bbb";
        webDriver2.get(test_url+"/index?username="+username2);

        WebElement sendText = webDriver.findElement(By.id("msg"));
        sendText.sendKeys("send text test");

        WebElement sendButton = webDriver.findElement(By.className("send"));
        sendButton.click();

        //check message shows at user2


        WebElement leaveChat = webDriver.findElement(By.className("exit"));
        leaveChat.click();
        assertThat(webDriver.findElement(By.className("submit")).getText().equals("login"));
        System.out.println("--------------LOGOUT SUCCESS-----------");

    }

}