# Initialization
accumulator = 0

# Main program loop
while True:
    # Get user input
    cmd = raw_input('>> ')
    if accumulator == 256 or accumulator == -1:
        # Overflow, reset accumulator
        accumulator = 0
    # Process input
    if cmd == 'i':
        accumulator += 1 # Increment
    elif cmd == 'd':
        accumulator += -1 # Decrement
    elif cmd == 'o':
        print accumulator # Output
    elif cmd == 's':
        accumulator *= accumulator # Square
    else:
        print 'Unrecognized command.'
