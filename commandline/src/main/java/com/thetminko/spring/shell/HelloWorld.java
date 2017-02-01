package com.thetminko.spring.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.ExitShellRequest;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

/**
 * Created by thetminko on 2/1/2017.
 */
@Component
public class HelloWorld implements CommandMarker {
  private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

  @CliCommand(value = "hello", help = "Hello World")
  public String sayHello(@CliOption(key = {"", "name"}) String name) throws InterruptedException {
    if (0 == run().getExitCode()) {
      LOG.info("Successfully finished activation of schools");
    }
    return "Hello " + name;
  }

  private ExitShellRequest run() throws InterruptedException {
    LOG.info("Running Thread to activate schools");
    Thread.sleep(500);
    return ExitShellRequest.NORMAL_EXIT;
  }
}
