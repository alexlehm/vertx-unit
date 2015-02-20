package io.vertx.ext.unit;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.impl.TestCaseImpl;

import java.util.concurrent.TimeUnit;

/**
 * A test case object can be used to create a single test.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@VertxGen
public interface TestCase {

  /**
   * Create a test case.
   *
   * @param name the test case name
   * @param testCase the test case
   * @return the created test case
   */
  static TestCase create(String name, Handler<Test> testCase) {
    return new TestCaseImpl(name, testCase);
  }

  /**
   * Assert the test case passes and block until it is executed. This method should be used from a non Vert.x
   * context, like a Junit test.
   */
  @GenIgnore
  void assertSuccess();

  /**
   * Assert the test case passes and block until it is executed. This method should be used from a non Vert.x
   * context, like a Junit test.
   *
   * @param timeout the suite timeout expressed in the {@code unit} argument
   * @param unit the suite {@code timeout} unit
   */
  @GenIgnore
  void assertSuccess(long timeout, TimeUnit unit);

  /**
   * Assert the test case passes and block until it is executed. This method should be used from a non Vert.x
   * context, like a Junit test.
   *
   * @param vertx the vert.x instance
   */
  @GenIgnore
  void assertSuccess(Vertx vertx);

  /**
   * Assert the test case passes and block until it is executed. This method should be used from a non Vert.x
   *
   * @param vertx the vert.x instance
   * @param timeout the suite timeout expressed in the {@code unit} argument
   * @param unit the suite {@code timeout} unit
   */
  @GenIgnore
  void assertSuccess(Vertx vertx, long timeout, TimeUnit unit);
}
