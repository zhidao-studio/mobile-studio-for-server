package io.github.zhidao.ms.common.dto;

import com.github.pagehelper.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页DTO
 * @author zhanls 2023/1/24 16:39
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "分页对象")
public class PageDTO<T> implements Serializable {
    private static final long serialVersionUID = -842910398399137354L;

    /**
     * 页数(前端请求传入)
     */
    @Schema(description = "页数(前端请求传入)")
    private Integer pageNum;

    /**
     * 每页数量(前端请求传入)
     */
    @Schema(description = "每页数量(前端请求传入)")
    private Integer pageSize;

    /**
     * 查询条件(前端请求传入)
     */
    @Schema(description = "查询条件(前端请求传入)")
    private T condition;

    /**
     * 总记录数(后端响应传出)
     */
    @Schema(description = "总记录数(后端响应传出)")
    private Long total;

    /**
     * 查询列表(后端响应传出)
     */
    @Schema(description = "查询列表(后端响应传出)")
    private List<T> result;

    public PageDTO(Page page, List<T> result) {
        this.total = page.getTotal();
        this.result = result;
    }
}
