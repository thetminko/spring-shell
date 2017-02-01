package com.thetminko.spring.shell;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.ExitShellRequest;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import static java.util.logging.Level.INFO;

/**
 * Created by thetminko on 2/1/2017.
 */
@Component
public class HelloWorld implements CommandMarker {
  @CliAvailabilityIndicator({"helloworld"})
  public boolean isAvailableCommand() {
    return true;
  }

  @CliCommand(value = "hello", help = "Hello World")
  public String sayHello(@CliOption(key = {"", "name"}) String name) throws InterruptedException {
    return "Hello " + name  + " exit code: " + run().getExitCode();
  }

  private ExitShellRequest run() throws InterruptedException {
    StopWatch sw = new StopWatch("Running ...");
    sw.start();
    Thread.sleep(500);
    sw.stop();

    return ExitShellRequest.NORMAL_EXIT;
  }
}
