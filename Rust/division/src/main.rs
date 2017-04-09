use std::env;

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

    let result = compute_division(numerator, denominator);
    println!("Result: {}", result);
}

fn compute_division(x: i32, y: i32) -> i32 {
    match y {
        0 => panic!("Division by 0"),
        1 => x,
        _ => x/y
    }
}