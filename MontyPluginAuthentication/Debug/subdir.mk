################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../pam_authenticate.c \
../pam_end.c \
../pam_start.c \
../principal.c 

OBJS += \
./pam_authenticate.o \
./pam_end.o \
./pam_start.o \
./principal.o 

C_DEPS += \
./pam_authenticate.d \
./pam_end.d \
./pam_start.d \
./principal.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: Cross GCC Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


