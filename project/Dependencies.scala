/*
 * Copyright (c) 2013-2021 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0, and
 * you may not use this file except in compliance with the Apache License
 * Version 2.0.  You may obtain a copy of the Apache License Version 2.0 at
 * http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Apache License Version 2.0 is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the Apache License Version 2.0 for the specific language
 * governing permissions and limitations there under.
 */
import sbt._

object Dependencies {

  val resolutionRepos = Seq(
    "Snowplow Analytics Maven repo".at("http://maven.snplow.com/releases/").withAllowInsecureProtocol(true),
    // For uaParser utils
    "user-agent-parser repo".at("https://clojars.org/repo/")
  )

  object V {
    // Java
    val awsSdk       = "1.11.822"
    val pubsub       = "1.113.7"
    val kafka        = "2.2.1"
    val nsqClient    = "1.3.0"
    val jodaTime     = "2.10.8"
    val slf4j        = "1.7.30"
    val config       = "1.4.1"
    val prometheus   = "0.9.0"
    val cbor         = "2.11.4" // See snowplow/snowplow/issues/4266
    val jackson      = "2.10.5.1" // force this version to mitigate security vulnerabilities (nsq only)
    val thrift       = "0.14.1" // force this version to mitigate security vulnerabilities
    // Scala
    val collectorPayload = "0.0.0"
    val akkaHttp         = "10.1.12"
    val akka             = "2.5.32"
    val scopt            = "4.0.1"
    val pureconfig       = "0.15.0"
    val badRows          = "2.1.1"
    // Scala (test only)
    val specs2 = "4.11.0"
  }

  object Libraries {
    // Java
    val jackson          = "com.fasterxml.jackson.core"       % "jackson-databind"        % V.jackson // nsq only
    val thrift           = "org.apache.thrift"                % "libthrift"               % V.thrift
    val kinesis          = "com.amazonaws"                    % "aws-java-sdk-kinesis"    % V.awsSdk
    val sqs              = "com.amazonaws"                    % "aws-java-sdk-sqs"        % V.awsSdk
    val pubsub           = "com.google.cloud"                 % "google-cloud-pubsub"     % V.pubsub
    val kafkaClients     = "org.apache.kafka"                 % "kafka-clients"           % V.kafka
    val nsqClient        = "com.snowplowanalytics"            % "nsq-java-client"         % V.nsqClient
    val jodaTime         = "joda-time"                        % "joda-time"               % V.jodaTime
    val slf4j            = "org.slf4j"                        % "slf4j-simple"            % V.slf4j
    val log4jOverSlf4j   = "org.slf4j"                        % "log4j-over-slf4j"        % V.slf4j
    val config           = "com.typesafe"                     % "config"                  % V.config
    val prometheus       = "io.prometheus"                    % "simpleclient"            % V.prometheus
    val prometheusCommon = "io.prometheus"                    % "simpleclient_common"     % V.prometheus
    val cbor             = "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % V.cbor

    // Scala
    val collectorPayload = "com.snowplowanalytics" % "collector-payload-1" % V.collectorPayload
    val badRows          = "com.snowplowanalytics" %% "snowplow-badrows"   % V.badRows
    val scopt            = "com.github.scopt"      %% "scopt"              % V.scopt
    val akkaHttp         = "com.typesafe.akka"     %% "akka-http"          % V.akkaHttp
    val akkaStream       = "com.typesafe.akka"     %% "akka-stream"        % V.akka
    val akkaSlf4j        = "com.typesafe.akka"     %% "akka-slf4j"         % V.akka
    val pureconfig       = "com.github.pureconfig" %% "pureconfig"         % V.pureconfig

    // Scala (test only)
    val specs2            = "org.specs2"        %% "specs2-core"         % V.specs2   % Test
    val akkaTestkit       = "com.typesafe.akka" %% "akka-testkit"        % V.akka     % Test
    val akkaHttpTestkit   = "com.typesafe.akka" %% "akka-http-testkit"   % V.akkaHttp % Test
    val akkaStreamTestkit = "com.typesafe.akka" %% "akka-stream-testkit" % V.akka     % Test
  }
}
