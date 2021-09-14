package com.snowplowanalytics.snowplow.collectors.scalastream.telemetry

// iglu:com.snowplowanalytics.oss/oss_context/jsonschema/1-0-1
private case class TelemetryPayload(
  userProvidedId: Option[String]  = None,
  moduleName: Option[String]      = None,
  moduleVersion: Option[String]   = None,
  instanceId: Option[String]      = None,
  region: Option[String]          = None,
  cloud: Option[CloudVendor]      = None,
  autoGeneratedId: Option[String] = None,
  applicationName: String,
  applicationVersion: String,
  appGeneratedId: String
)
