package dev.api.application.inbound.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Schema(name = "Subscription", description = "Subscription profile id.", implementation = SubscriptionResponse.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubscriptionResponse(

        @Schema(name = "id", description = "Subscription profile id.",
                examples = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,

        @Schema(name = "value", description = "Subscription plan value.", examples = "19.99")
        BigDecimal value,

        @Schema(name = "totalAmount", description = "Subscription total amount paid.", examples = "498.76")
        BigDecimal totalAmount,

        @Schema(name = "beginDate", description = "Subscription begin plan date.", examples = "04/22/2025")
        LocalDateTime beginDate,

        @Schema(name = "endDate", description = "Subscription end plan date (if the plan was cancelled).",
                examples = "11/07/2025")
        LocalDateTime endDate,

        @Schema(name = "lastInvoice", description = "Subscription last plan invoice.", examples = "11/07/2025")
        LocalDateTime lastInvoice,

        @Schema(name = "active", description = "Subscription status (false if was cancelled).", examples = "11/07/2025")
        Boolean active
) {
}
