package com.server.service.base;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author wangning
 */
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> implements Serializable {
    private Instant createdDate;
    private String createdBy;
    private Instant updateDate;
}
