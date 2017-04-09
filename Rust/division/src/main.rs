fn main() {
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