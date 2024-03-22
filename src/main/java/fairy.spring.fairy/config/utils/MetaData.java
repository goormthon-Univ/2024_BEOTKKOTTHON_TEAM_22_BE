package fairy.spring.fairy.config.utils;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class MetaData {
    //    @CreatedDate
//    @Column(nullable = false)
    private LocalDateTime createdAt;

    //    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    //    @ColumnDefault("false")
    private boolean isDeleted;
}
