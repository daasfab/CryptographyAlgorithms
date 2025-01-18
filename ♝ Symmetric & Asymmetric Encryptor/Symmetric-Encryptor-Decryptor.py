from cryptography.fernet import Fernet
from termcolor import colored


inputMessage = input("Enter a message: ")

key = Fernet.generate_key() # Generating the key

encoded_obj = Fernet(key)

print(f"Yncrypting message: {message}")

encrypted_message = encoded_obj.encrypt(message.encode())

print(f"Encryption result: {encrypted_message}")

original_message = encoded_obj.decrypt(encrypted_message).decode()

print(f"Original message: {original_message}")

# Outputting the encryption success message:
if original_message == inputMessage:
    print(colored("Encrypting Success", "green"))
else:
    print(colored("Encrypting Failure", "red"))


