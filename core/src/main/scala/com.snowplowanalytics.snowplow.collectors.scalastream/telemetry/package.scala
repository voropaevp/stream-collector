package com.snowplowanalytics.snowplow.collectors.scalastream

import com.snowplowanalytics.iglu.core.{SchemaKey, SchemaVer, SelfDescribingData}
import com.snowplowanalytics.snowplow.collectors.scalastream.model.TelemetryConfig
import com.snowplowanalytics.snowplow.collectors.scalastream.telemetry.CloudVendor._
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._

package object telemetry {
  private val teleUuid: String = java.util.UUID.randomUUID.toString

  private val telemetrySchema: SchemaKey =
    SchemaKey("com.snowplowanalytics.oss", "oss_context", "jsonschema", SchemaVer.Full(1, 0, 1))

  /** Makes [[SelfDescribingData]] to be used for telemetry heartbeats.
    * Don't forget to cache this event after the creation.
    *
    * @param teleCfg - telemetry configuration
    * @param cloud - cloud vendor
    * @param region - deployment region
    * @param appName - application name as defined during build (take it from BuildInfo)
    * @param appVersion - application name as defined during build (take it from BuildInfo)
    * @return heartbeat event. Same event should be used for all heartbeats.
    */
  def makeHeartbeatEvent(
    teleCfg: TelemetryConfig,
    cloud: Option[CloudVendor],
    region: Option[String],
    appName: String,
    appVersion: String
  ): SelfDescribingData[Json] = SelfDescribingData(
    telemetrySchema,
    TelemetryPayload(
      userProvidedId     = teleCfg.userProvidedId,
      moduleName         = teleCfg.moduleName,
      moduleVersion      = teleCfg.moduleVersion,
      instanceId         = teleCfg.instanceId,
      region             = region,
      cloud              = cloud,
      applicationName    = appName,
      applicationVersion = appVersion,
      appGeneratedId     = teleUuid
    ).asJson
  )

}
