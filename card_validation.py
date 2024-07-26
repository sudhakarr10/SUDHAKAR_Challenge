import re

def is_valid_credit_card(card_number):
    # Check if the card starts with 4, 5, or 6 and contains 16 digits or groups of 4 digits separated by hyphens
    if not re.match(r'^[456]\d{3}(-?\d{4}){3}$', card_number):
        return False

    # Check if the card number has any invalid characters or separators other than hyphens
    if re.search(r'[^0-9-]', card_number):
        return False

    # Check if the card number has four or more consecutive repeated digits
    card_number_no_hyphen = card_number.replace('-', '')
    if re.search(r'(\d)\1{3,}', card_number_no_hyphen):
        return False

    return True

def main():
    N = int(input("Enter the number of credit cards to validate: "))
    for _ in range(N):
        card_number = input()
        if is_valid_credit_card(card_number):
            print("Valid")
        else:
            print("Invalid")

if __name__ == "__main__":
    main()