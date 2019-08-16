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
        WebElement username1 = webDriver.findElement(By.name("username"));
        assertThat(webDriver.findElement(By.id("username")).getText()).isEqualTo(username1.getText());

    }

    @Test
    public void chatAndLeave()
    {
        webDriver = new HtmlUnitDriver();

        String username="aaa";
        webDriver.get(test_url+"/index?username="+username);

        WebElement sendText = webDriver.findElement(By.id("msg"));
        sendText.sendKeys("send text test");

        WebElement sendButton = webDriver.findElement(By.className("send"));
        sendButton.click();

        WebElement leaveChat = webDriver.findElement(By.className("exit"));
        leaveChat.click();

        assertThat(webDriver.getCurrentUrl()).contains("/");

    }

}