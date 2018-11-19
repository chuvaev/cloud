package chuvaev.cloud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ilya Chuvaev
 */
@Getter
@Setter
@NoArgsConstructor
public class ResultDTO {

    @Nullable
    protected Boolean success;

    @Nullable
    protected String message;

    public ResultDTO(@Nullable boolean success, String message){
        this.success = success;
        this.message = message;
    }

}
