package org.jenkinsci.plugins.envshowcomputer;


import hudson.EnvVars;
import hudson.model.Action;
import hudson.model.Computer;
import hudson.slaves.EnvironmentVariablesNodeProperty;
import hudson.slaves.NodeProperty;

import java.util.Map;
import java.util.Set;

/**
 * Show computer environment variables (@link Computer)
 *
 * @author Marc MacIntyre
 *
 */
public class ShowComputerEnv implements Action {
    private Computer computer;

    public ShowComputerEnv(Computer computer) {
        this.computer = computer;
    }

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return "Show Computer Environment";
    }

    public String getUrlName() {
        return null;
    }

    public Set<Map.Entry<String, String>> getEnvironmentVariables() {
        for (NodeProperty p: computer.getNode().getNodeProperties()) {
            if (p.getClass().isAssignableFrom(EnvironmentVariablesNodeProperty.class)) {
                EnvVars ev = ((EnvironmentVariablesNodeProperty)p).getEnvVars();
                return ev.entrySet();
            }
        }
        return null;
    }
}
