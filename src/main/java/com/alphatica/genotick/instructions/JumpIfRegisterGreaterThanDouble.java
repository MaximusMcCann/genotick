package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfRegisterGreaterThanDouble extends RegDoubleJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3245923977507621290L;

    private JumpIfRegisterGreaterThanDouble(JumpIfRegisterGreaterThanDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfRegisterGreaterThanDouble() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public JumpIfRegisterGreaterThanDouble copy() {
        return new JumpIfRegisterGreaterThanDouble(this);
    }
}
