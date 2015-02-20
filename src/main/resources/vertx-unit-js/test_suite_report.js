/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

/** @module vertx-unit-js/test_suite_report */
var utils = require('vertx-js/util/utils');
var ReadStream = require('vertx-js/read_stream');
var TestCaseReport = require('vertx-unit-js/test_case_report');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JTestSuiteReport = io.vertx.ext.unit.report.TestSuiteReport;

/**
 The test suite reports is basically a stream of events reporting the test suite execution.

 @class
*/
var TestSuiteReport = function(j_val) {

  var j_testSuiteReport = j_val;
  var that = this;
  ReadStream.call(this, j_val);

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.exceptionHandler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_testSuiteReport.exceptionHandler(function(jVal) {
      arg0(utils.convReturnTypeUnknown(jVal));
    });
      return that;
    } else utils.invalidArgs();
  };

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.handler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_testSuiteReport.handler(function(jVal) {
      arg0(new TestCaseReport(jVal));
    });
      return that;
    } else utils.invalidArgs();
  };

  /**

   @public

   @return {ReadStream}
   */
  this.pause = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_testSuiteReport.pause();
      return that;
    } else utils.invalidArgs();
  };

  /**

   @public

   @return {ReadStream}
   */
  this.resume = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_testSuiteReport.resume();
      return that;
    } else utils.invalidArgs();
  };

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.endHandler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_testSuiteReport.endHandler(arg0);
      return that;
    } else utils.invalidArgs();
  };

  /**
   @return the test suite name

   @public

   @return {string}
   */
  this.name = function() {
    var __args = arguments;
    if (__args.length === 0) {
      if (that.cachedname == null) {
        that.cachedname = j_testSuiteReport.name();
      }
      return that.cachedname;
    } else utils.invalidArgs();
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_testSuiteReport;
};

// We export the Constructor function
module.exports = TestSuiteReport;