def inventory_numbers(history):
    inventory = {}
    for i in range(0,len(history)-1):
        current_number, next_number = history[i], history[i+1]
        #print("c = {} / n = {}".format(current, next))

        if current_number not in inventory:
            inventory[current_number] = {next_number: 1}
        else:
            stored_dict = inventory[current_number]
            if next_number not in stored_dict:
                #stored_dict[next_number] += 1
                #else:
                stored_dict[next_number] = 1
    return inventory

def conditional_roulette_probs(history):
    """
    Example:
    conditional_roulette_probs([1, 3, 1, 5, 1])
    > {1: {3: 0.5, 5: 0.5},
       3: {1: 1.0},
       5: {1: 1.0}
      }
    """
    probabilities = {}
    inventory = inventory_numbers(history)
    print(inventory)
    for key, stored_dict in inventory_numbers(history).items():
        print("key={} / dict={}".format(key, stored_dict))
        prob_dict = {}
        for pk, pv in stored_dict.items():
            prob_dict[pk] = pv/len(stored_dict)
        probabilities[key] = prob_dict


    return probabilities

if __name__ == '__main__':
    conditional_roulette_probs([1, 3, 1, 5, 1])