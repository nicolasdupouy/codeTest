use std::env;

struct Division {
    numerator: i32,
    denominator: i32,
}

impl Division {
    fn compute(&self) -> i32 {
        match self.denominator {
            0 => panic!("Division by 0"),
            1 => self.numerator,
            _ => self.numerator / self.denominator
        }
    }
}

fn main() {
    let numerator = match env::args().nth(1) {
        Some(argument) => argument,
        None => panic!("Numerator mandatory in argument.")
    };
    let denominator = match env::args().nth(2) {
        Some(argument) => argument,
        None => panic!("Denominator mandatory in argument.")
    };
    println!("Numerator is: {}, and Denominator is {}", numerator, denominator);

    let numerator = match numerator.parse::<i32>() {
        Ok(numerator) => numerator,
        Err(error) => panic!("Impossible to convert argument. Reason: {}", error)
    };
    let denominator = match denominator.parse::<i32>() {
        Ok(denominator) => denominator,
        Err(error) => panic!("Impossible to convert argument. Reason: {}", error)
    };
    println!("Numerator is: {}, and Denominator is {}", numerator, denominator);

    let division = Division {numerator: numerator, denominator: denominator};
    let result = division.compute();
    println!("Result: {}", result);
}