package org.jenkinsci.plugins.envshowcomputer;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Computer;
import hudson.model.TransientComputerActionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Show computer environment variables (@link Computer)
 *
 * @author Marc MacIntyre
 *
 */
@Extension
public class ShowComputerEnvFactory extends TransientComputerActionFactory {
    @Override
    public Collection<? extends Action> createFor(Computer computer) {
        List<Action> actions = new ArrayList<Action>();
        actions.add(new ShowComputerEnv(computer));
        return actions;
    }
}
