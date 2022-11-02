# lombok

- getters, setters, constructors
- DTOs
- builder
- logger
- best practices


- don't put @Data to @Entity (entities)
- dont use @ToString (lazy load problems)
- dont use parent.getChildren().add() => use addChild()
- use @Data on value objects
- use @Value (no need for private fields)
- use @Embeddable
- don't use final on fields with hibernate
- use @Setter(AccessLevel.NONE) on children

- getter for children should return unmodifiable list

- @AllArgsConstructor
- @NoArgsConstructor

- dont override @Hashcode @Equals on entities
- use external hascode and equals to compare entities

- all spring services have @RequiredArgsConstructor

- @Autowired not needed on constructor
- use @Slf4j for services

@Entity

- @Data + @Builder are good together for immutable objects
- use accessor chain instead of @Builder
- validate immutable objects using Objects.requireNonNull() instead of @NonNull
- fluent setters wont work with fluent setters, bluider will work
- very few people validate stuff in constructor
- when checked exception, throw it as a runtime exception

# @Builder

[exclude property from builder](https://stackoverflow.com/questions/30717640/how-to-exclude-property-from-lombok-builder)
@builder and @accessors
https://nickolasfisher.com/blog/Exploring-Lombok-How-to-use-Builder-Accessors-and-Wither-for-POJO-Classes

# @Builder.Default

in combination with builder

@Builder.Default
private AchAccountType receiverAccountType = AchAccountType.CHECKING;

# @Value

makes fields private and final

@Value
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE) //Hides the constructor to force useage of the Builder.

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))

# @Singular

used with @Builder to generate getter for collections
