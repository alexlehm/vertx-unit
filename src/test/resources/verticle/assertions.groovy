package verticle

import io.vertx.groovy.ext.unit.TestSuite;

def suite = TestSuite.create("the_suite"); 

suite.test("assert_equals", { test ->
    test.assertEquals(0, 0);
    test.assertEquals(10, 10);
    test.assertEquals(0.12, 0.12);
    test.assertEquals(true, true);
    test.assertEquals(false, false);
    test.assertEquals("the_string", "the_" + "string");
    test.assertEquals([foo:1,bar:"juu"], [foo:1,bar:"juu"]);
    test.assertEquals([], []);
    test.assertEquals([123], [123]);
}).test("fail_assert_equals_1", { test ->
    test.assertEquals(0, 1);
}).test("fail_assert_equals_2", { test ->
    test.assertEquals(0.12, 0.13);
}).test("fail_assert_equals_3", { test ->
    test.assertEquals(true, false);
}).test("fail_assert_equals_4", { test ->
    test.assertEquals(false, true);
}).test("fail_assert_equals_5", { test ->
    test.assertEquals("foo", "bar");
}).test("fail_assert_equals_6", { test ->
    test.assertEquals([foo:1,bar:"juu"], [foo:1,bar:"daa"]);
}).test("fail_assert_equals_7", { test ->
    test.assertEquals([123], [321]);
});

suite.test("assert_equals_with_message", { test ->
    test.assertEquals(0, 0, "the_message");
    test.assertEquals(10, 10, "the_message");
    test.assertEquals(0.12, 0.12, "the_message");
    test.assertEquals(true, true, "the_message");
    test.assertEquals(false, false, "the_message");
    test.assertEquals("the_string", "the_" + "string", "the_message");
    test.assertEquals([foo:1,bar:"juu"], [foo:1,bar:"juu"], "the_message");
    test.assertEquals([], [], "the_message");
    test.assertEquals([123], [123], "the_message");
}).test("fail_assert_equals_with_message_1", { test ->
    test.assertEquals(0, 1, "the_message");
}).test("fail_assert_equals_with_message_2", { test ->
    test.assertEquals(0.12, 0.13, "the_message");
}).test("fail_assert_equals_with_message_3", { test ->
    test.assertEquals(true, false, "the_message");
}).test("fail_assert_equals_with_message_4", { test ->
    test.assertEquals(false, true, "the_message");
}).test("fail_assert_equals_with_message_5", { test ->
    test.assertEquals("foo", "bar", "the_message");
}).test("fail_assert_equals_with_message_6", { test ->
    test.assertEquals([foo:1,bar:"juu"], [foo:1,bar:"daa"], "the_message");
}).test("fail_assert_equals_with_message_7", { test ->
    test.assertEquals([123], [321], "the_message");
});

suite.test("assert_not_equals", { test ->
    test.assertNotEquals(0, 1);
    test.assertNotEquals(0.12, 0.13);
    test.assertNotEquals(true, false);
    test.assertNotEquals(false, true);
    test.assertNotEquals("foo", "bar");
    test.assertNotEquals([foo:1,bar:"juu"], [foo:1,bar:"daa"]);
    test.assertNotEquals([123], [321]);
}).test("fail_assert_equals_1", { test ->
    test.assertNotEquals(0, 0);
}).test("fail_assert_equals_2", { test ->
    test.assertNotEquals(0.12, 0.12);
}).test("fail_assert_equals_3", { test ->
    test.assertNotEquals(true, true);
}).test("fail_assert_equals_4", { test ->
    test.assertNotEquals(false, false);
}).test("fail_assert_equals_5", { test ->
    test.assertNotEquals("the_string", "the_" + "string");
}).test("fail_assert_equals_6", { test ->
    test.assertNotEquals([foo:1,bar:"juu"], [foo:1,bar:"juu"]);
}).test("fail_assert_equals_7", { test ->
    test.assertNotEquals([], []);
}).test("fail_assert_equals_8", { test ->
    test.assertNotEquals([123], [123]);
});

suite.test("assert_not_equals_with_message", { test ->
    test.assertNotEquals(0, 1, "the_message");
    test.assertNotEquals(0.12, 0.13, "the_message");
    test.assertNotEquals(true, false, "the_message");
    test.assertNotEquals(false, true, "the_message");
    test.assertNotEquals("foo", "bar", "the_message");
    test.assertNotEquals([foo:1,bar:"juu"], [foo:1,bar:"daa"], "the_message");
    test.assertNotEquals([123], [321], "the_message");
}).test("fail_assert_equals_with_message_1", { test ->
    test.assertNotEquals(0, 0, "the_message");
}).test("fail_assert_equals_with_message_2", { test ->
    test.assertNotEquals(0.12, 0.12, "the_message");
}).test("fail_assert_equals_with_message_3", { test ->
    test.assertNotEquals(true, true, "the_message");
}).test("fail_assert_equals_with_message_4", { test ->
    test.assertNotEquals(false, false, "the_message");
}).test("fail_assert_equals_with_message_5", { test ->
    test.assertNotEquals("the_string", "the_" + "string", "the_message");
}).test("fail_assert_equals_with_message_6", { test ->
    test.assertNotEquals([foo:1,bar:"juu"], [foo:1,bar:"juu"], "the_message");
}).test("fail_assert_equals_with_message_7", { test ->
    test.assertNotEquals([], [], "the_message");
}).test("fail_assert_equals_with_message_8", { test ->
    test.assertNotEquals([123], [123], "the_message");
});

suite.test("assert_true", { test ->
    test.assertTrue(true);
}).test("fail_assert_true", { test ->
    test.assertTrue(false);
});

suite.test("assert_true_with_message", { test ->
    test.assertTrue(true, "the_message");
}).test("fail_assert_true_with_message", { test ->
    test.assertTrue(false, "the_message");
});

suite.test("assert_false", { test ->
    test.assertFalse(false);
}).test("fail_assert_false", { test ->
    test.assertFalse(true);
});

suite.test("assert_false_with_message", { test ->
    test.assertFalse(false, "the_message");
}).test("fail_assert_false_with_message", { test ->
    test.assertFalse(true, "the_message");
});

suite.test("fail_", { test ->
    test.fail();
});

suite.test("fail_with_message", { test ->
    test.fail("the_message");
});

suite.run(vertx, [reporters:[[to: "bus", at: "assert_tests"]]]);
