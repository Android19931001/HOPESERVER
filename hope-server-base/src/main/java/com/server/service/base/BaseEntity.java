package com.server.service.base;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wangning
 */
@Data
@Getter
@Setter
public class BaseEntity<T extends Model<?>> extends Model<T> {

//    public Instant createdDate;
//
//    public Instant lastModifiedDate;
//
//    public String createdBy;
//
//    public String lastModifiedBy;
//
//    public int versionLock;
}
