package com.seaboxdata.auth.server.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seaboxdata.commons.utils.LocalDateTimeJsonDeserializer;
import com.seaboxdata.commons.utils.LocalDateTimeJsonSerializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户-资源许可表
 * </p>
 *
 * @author makaiyu
 * @since 2019-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
public class OauthUserPermission implements Serializable {

    private static final long serialVersionUID = 8968181949828667366L;
    /** 主键id */
    @TableId(value = "id", type = IdType.INPUT)
    @ToString.Include
    private Long id;

    /** 用户Id */
    @ToString.Include
    private Long userId;

    /** 租户Id */
    private Long tenantId;

    /** 资源许可Id */
    private Long permissionId;

    /** 权限码 */
    private String permissionCode;

    /** 0:增 1:减 */
    private Long status;

    /** 操作人Id */
    private Long operatorId;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = LocalDateTimeJsonSerializable.class)
    @JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
    private LocalDateTime createTime;

    /** 修改时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = LocalDateTimeJsonSerializable.class)
    @JsonDeserialize(using = LocalDateTimeJsonDeserializer.class)
    private LocalDateTime updateTime;
}
