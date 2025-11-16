package N2_class;

public class AgeValidationRule extends ValidationRule<Byte> {
    public AgeValidationRule(Byte age) {
        super(age, "Возраст для подачи на ипотеку должен быть старше 18 лет");
    }

    @Override
    public boolean isValid() {
        return value != null && value >= 18;
    }
}