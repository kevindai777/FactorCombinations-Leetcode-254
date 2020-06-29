//Objective is to find all unique factor combinations for a certain number.
//Factors must not include 1.

let num = 8


//O() backtracking solution.

let temp = []
let result = []
let index = 2
let product = 1

backtrack(temp, product, index)

function backtrack(temp, product, index) {
    if (product > num) {
        return
    }

    if (product == num) {
        result.push([...temp])
        return
    }

    //Here we only have to check up to (num / product) since every time
    //we multiply the product by an integer, the values we can iterate
    //through to find a match decreases.
    //Make sure i !== num to avoid (1, 8)
    for (let i = index; i <= Math.floor(num / product); i++) {
        if (num % i == 0 && i !== num) {
            temp.push(i)
            backtrack(temp, product * i, i)
            temp.pop()
        }
    }
}

return result