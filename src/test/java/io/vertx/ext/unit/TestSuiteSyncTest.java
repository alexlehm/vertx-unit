package io.vertx.ext.unit;

import io.vertx.core.Vertx;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class TestSuiteSyncTest extends TestSuiteTestBase {

  public TestSuiteSyncTest() {
    super();
    getRunner = TestSuite::runner;
    run = TestSuiteRunner::run;
    completeAsync = Async::complete;
  }

  @Override
  protected boolean checkTest(Test test) {
    return Vertx.currentContext() == null && test.vertx() == null;
  }
}
