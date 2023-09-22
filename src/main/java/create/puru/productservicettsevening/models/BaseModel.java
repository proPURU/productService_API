package create.puru.productservicettsevening.models;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter


public class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastUpdate;
    private boolean isDeleted;
}
