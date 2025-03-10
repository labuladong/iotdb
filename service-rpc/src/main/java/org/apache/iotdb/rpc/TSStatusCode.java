/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.rpc;

import java.util.HashMap;
import java.util.Map;

/**
 * When update this class, remember to update the following files
 *
 * <p>docs/UserGuide/API/Status-Codes.md
 *
 * <p>docs/zh/UserGuide/API/Status-Codes.md
 */
public enum TSStatusCode {
  SUCCESS_STATUS(200),

  // System level
  INCOMPATIBLE_VERSION(201),
  CONFIGURATION_ERROR(202),
  START_UP_ERROR(203),
  SHUT_DOWN_ERROR(204),

  // General Error
  UNSUPPORTED_OPERATION(300),
  EXECUTE_STATEMENT_ERROR(301),
  MULTIPLE_ERROR(302),
  ILLEGAL_PARAMETER(303),
  OVERLAP_WITH_EXISTING_TASK(304),
  INTERNAL_SERVER_ERROR(305),

  // Client,
  REDIRECTION_RECOMMEND(400),

  // Schema Engine
  DATABASE_NOT_EXIST(500),
  DATABASE_ALREADY_EXISTS(501),
  SERIES_OVERFLOW(502),
  TIMESERIES_ALREADY_EXIST(503),
  TIMESERIES_IN_BLACK_LIST(504),
  ALIAS_ALREADY_EXIST(505),
  PATH_ALREADY_EXIST(506),
  METADATA_ERROR(507),
  PATH_NOT_EXIST(508),
  ILLEGAL_PATH(509),
  CREATE_TEMPLATE_ERROR(510),
  DUPLICATED_TEMPLATE(511),
  UNDEFINED_TEMPLATE(512),
  TEMPLATE_NOT_SET(513),
  DIFFERENT_TEMPLATE(514),
  TEMPLATE_IS_IN_USE(515),
  TEMPLATE_INCOMPATIBLE(516),
  SEGMENT_NOT_FOUND(517),
  PAGE_OUT_OF_SPACE(518),
  RECORD_DUPLICATED(519),
  SEGMENT_OUT_OF_SPACE(520),
  SCHEMA_FILE_NOT_EXISTS(521),
  OVERSIZE_RECORD(522),
  SCHEMA_FILE_REDO_LOG_BROKEN(523),
  TEMPLATE_NOT_ACTIVATED(524),

  // Storage Engine
  SYSTEM_READ_ONLY(600),
  STORAGE_ENGINE_ERROR(601),
  STORAGE_ENGINE_NOT_READY(602),
  DATAREGION_PROCESS_ERROR(603),
  TSFILE_PROCESSOR_ERROR(604),
  WRITE_PROCESS_ERROR(605),
  WRITE_PROCESS_REJECT(606),
  OUT_OF_TTL(607),
  COMPACTION_ERROR(608),
  ALIGNED_TIMESERIES_ERROR(609),
  WAL_ERROR(610),
  DISK_SPACE_INSUFFICIENT(611),

  // Query Engine
  SQL_PARSE_ERROR(700),
  SEMANTIC_ERROR(701),
  GENERATE_TIME_ZONE_ERROR(702),
  SET_TIME_ZONE_ERROR(703),
  QUERY_NOT_ALLOWED(704),
  LOGICAL_OPERATOR_ERROR(705),
  LOGICAL_OPTIMIZE_ERROR(706),
  UNSUPPORTED_FILL_TYPE(707),
  QUERY_PROCESS_ERROR(708),
  MPP_MEMORY_NOT_ENOUGH(709),
  CLOSE_OPERATION_ERROR(710),
  TSBLOCK_SERIALIZE_ERROR(711),
  INTERNAL_REQUEST_TIME_OUT(712),
  INTERNAL_REQUEST_RETRY_ERROR(713),

  // Authentication
  AUTHENTICATION_ERROR(800),
  WRONG_LOGIN_PASSWORD(801),
  NOT_LOGIN(802),
  NO_PERMISSION(803),
  UNINITIALIZED_AUTH_ERROR(804),
  USER_NOT_EXIST(805),
  ROLE_NOT_EXIST(806),
  CLEAR_PERMISSION_CACHE_ERROR(807),

  // Partition Error
  MIGRATE_REGION_ERROR(900),
  CREATE_REGION_ERROR(901),
  DELETE_REGION_ERROR(902),
  PARTITION_CACHE_UPDATE_ERROR(903),
  CONSENSUS_NOT_INITIALIZED(904),
  REGION_LEADER_CHANGE_ERROR(905),
  NO_AVAILABLE_REGION_GROUP(906),

  // Cluster Manager
  ADD_CONFIGNODE_ERROR(1000),
  REMOVE_CONFIGNODE_ERROR(1001),
  DATANODE_ALREADY_REGISTERED(1002),
  NO_ENOUGH_DATANODE(1003),
  DATANODE_NOT_EXIST(1004),
  DATANODE_STOP_ERROR(1005),
  REMOVE_DATANODE_ERROR(1006),
  REGISTER_REMOVED_DATANODE(1007),
  CAN_NOT_CONNECT_DATANODE(1008),

  // Sync, Load TsFile
  LOAD_FILE_ERROR(1100),
  LOAD_PIECE_OF_TSFILE_ERROR(1101),
  DESERIALIZE_PIECE_OF_TSFILE_ERROR(1102),
  SYNC_CONNECTION_ERROR(1103),
  SYNC_FILE_REDIRECTION_ERROR(1104),
  SYNC_FILE_ERROR(1105),
  CREATE_PIPE_SINK_ERROR(1106),
  PIPE_ERROR(1107),
  PIPESERVER_ERROR(1108),
  VERIFY_METADATA_ERROR(1109),

  // UDF
  UDF_LOAD_CLASS_ERROR(1200),
  UDF_DOWNLOAD_ERROR(1201),
  CREATE_UDF_ON_DATANODE_ERROR(1202),
  DROP_UDF_ON_DATANODE_ERROR(1203),

  // Trigger
  CREATE_TRIGGER_ERROR(1300),
  DROP_TRIGGER_ERROR(1301),
  TRIGGER_FIRE_ERROR(1302),
  TRIGGER_LOAD_CLASS_ERROR(1303),
  TRIGGER_DOWNLOAD_ERROR(1304),
  CREATE_TRIGGER_INSTANCE_ERROR(1305),
  ACTIVE_TRIGGER_INSTANCE_ERROR(1306),
  DROP_TRIGGER_INSTANCE_ERROR(1307),
  UPDATE_TRIGGER_LOCATION_ERROR(1308),

  // Continuous Query
  NO_SUCH_CQ(1400),
  CQ_ALREADY_ACTIVE(1401),
  CQ_AlREADY_EXIST(1402),
  CQ_UPDATE_LAST_EXEC_TIME_ERROR(1403);

  private final int statusCode;

  private static final Map<Integer, TSStatusCode> CODE_MAP = new HashMap<>();

  static {
    for (TSStatusCode value : TSStatusCode.values()) {
      CODE_MAP.put(value.getStatusCode(), value);
    }
  }

  TSStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public static TSStatusCode representOf(int statusCode) {
    return CODE_MAP.get(statusCode);
  }

  @Override
  public String toString() {
    return String.format("%s(%d)", name(), getStatusCode());
  }
}
