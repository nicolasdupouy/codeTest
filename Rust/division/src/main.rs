use std::env;

fn main() {
    let numerator = match env::args().nth(1) {
        Some(argument) => argument,
        None => panic!("Numerator mandatory in argument.")
    };
    println!("Numerator is: {}", numerator);

    let result = compute_division(-4, 2);
    println!("Result: {}", result);
}

fn compute_division(x: i32, y: i32) -> i32 {
    match y {
        0 => panic!("Division by 0"),
        1 => x,
        _ => x/y
    }
}