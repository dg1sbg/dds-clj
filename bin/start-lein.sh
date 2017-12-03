#!/bin/bash

unset CLASSPATH
lein clean && lein deps && lein repl

