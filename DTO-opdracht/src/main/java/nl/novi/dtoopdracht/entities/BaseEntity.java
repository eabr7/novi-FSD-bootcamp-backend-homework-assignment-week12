package nl.novi.dtoopdracht.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    // ID (for de primary key in SQL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // defining columns
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "edited_date")
    private LocalDateTime editDate;

    // Use of @PrePersist and @PreUpdate
    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
        editDate = createDate;
    }

    @PreUpdate
    protected void onUpdate() {
        editDate = LocalDateTime.now();
    }

    // constructor (HAS TO BE NO-ARGS, in this case because if ID and @PrePersist / @PreUpdate)
    public BaseEntity() {

    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }
}