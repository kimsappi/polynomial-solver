NAME = computor
SRCS = com/computor/*.java com/computor/Equations/*.java
OBJS = $(subst .java,.class,$(SRCS))

all: $(NAME)

$(NAME):
	javac $(SRCS)

clean:
	rm -f $(OBJS)

fclean: clean

re: fclean all

.PHONY: all, re, clean, fclean, $(NAME)
