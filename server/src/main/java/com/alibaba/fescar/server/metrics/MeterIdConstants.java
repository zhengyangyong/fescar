package com.alibaba.fescar.server.metrics;

import com.alibaba.fescar.metrics.Id;
import com.alibaba.fescar.metrics.IdConstants;

public class MeterIdConstants {
  public static final Id COUNTER_ACTIVE = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_GAUGE)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_ACTIVE);

  public static final Id COUNTER_COMMITTED = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_COUNTER)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_COMMITTED);

  public static final Id COUNTER_ROLLBACK = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_COUNTER)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_ROLLBACK);

  public static final Id HISTOGRAM_COMMITTED = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_HISTOGRAM)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_COMMITTED);

  public static final Id HISTOGRAM_ROLLBACK = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_HISTOGRAM)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_ROLLBACK);

  public static final Id TIMER_COMMITTED = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_TIMER)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_COMMITTED);

  public static final Id TIMER_ROLLBACK = new Id(IdConstants.FESCAR_TRANSACTION)
      .addTag(IdConstants.ROLE_KEY, IdConstants.ROLE_VALUE_TC)
      .addTag(IdConstants.METER_KEY, IdConstants.METER_VALUE_TIMER)
      .addTag(IdConstants.STATUS_KEY, IdConstants.STATUS_VALUE_ROLLBACK);
}
