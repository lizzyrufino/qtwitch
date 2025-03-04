package dev.api.domain.entities;

import dev.api.application.inbound.dto.response.SubscriptionResponse;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscription")
public class Subscription extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "value", nullable = false, precision = 2)
    private BigDecimal value;

    @Column(name = "total_amount", nullable = false, precision = 2)
    private BigDecimal totalAmount;

    @Column(name = "begin_date", nullable = false)
    private LocalDateTime beginDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "last_invoice")
    private LocalDateTime lastInvoice;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public SubscriptionResponse toResponse() {
        return new SubscriptionResponse(id, value, totalAmount, beginDate, endDate, lastInvoice, active);
    }

    public static Subscription create(BigDecimal value) {
        var newSubscription = new Subscription();
        newSubscription.value = value;
        newSubscription.totalAmount = value;
        newSubscription.beginDate = LocalDateTime.now();
        newSubscription.active = true;

        return newSubscription;
    }
}
