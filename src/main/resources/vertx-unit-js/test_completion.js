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

/** @module vertx-unit-js/test_completion */
var utils = require('vertx-js/util/utils');
var Future = require('vertx-js/future');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JTestCompletion = io.vertx.ext.unit.TestCompletion;

/**

 @class
*/
var TestCompletion = function(j_val) {

  var j_testCompletion = j_val;
  var that = this;

  /**

   @public
   @param future {Future} 
   */
  this.resolve = function(future) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'object' && __args[0]._jdel) {
      j_testCompletion.resolve(future._jdel);
    } else utils.invalidArgs();
  };

  /**

   @public
   @param completionHandler {function} 
   */
  this.handler = function(completionHandler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_testCompletion.handler(function(ar) {
      if (ar.succeeded()) {
        completionHandler(null, null);
      } else {
        completionHandler(null, ar.cause());
      }
    });
    } else utils.invalidArgs();
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_testCompletion;
};

// We export the Constructor function
module.exports = TestCompletion;