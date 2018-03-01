package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterNotEqualRegister extends RegRegJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5597151246876888643L;

    private JumpIfRegisterNotEqualRegister(JumpIfRegisterNotEqualRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterNotEqualRegister() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterNotEqualRegister copy() {
        return new JumpIfRegisterNotEqualRegister(this);
    }
}
